const url = 'http://localhost:8080/sse/sensors';
let es = null;
let isPaused = false;


const readingsEl = document.getElementById('readings');
const logEl = document.getElementById('log');
const btnConnect = document.getElementById('btnConnect');
const btnDisconnect = document.getElementById('btnDisconnect');
const btnToggle = document.getElementById('btnToggle');


function log(text) {
const time = new Date().toLocaleTimeString();
logEl.textContent = `[${time}] ${text}\n` + logEl.textContent;
}


function addReading(reading) {
const li = document.createElement('li');
li.innerHTML = `📡 <strong>${reading.sensorId}</strong> — Temp: ${reading.temperature}°C | Hum: ${reading.humidity}% <br><small>${new Date(reading.timestamp).toLocaleString()}</small>`;
readingsEl.prepend(li);
}


function connect() {
if (es) return;
es = new EventSource(url);


es.onopen = () => {
log('Conexión SSE abierta');
btnConnect.disabled = true;
btnDisconnect.disabled = false;
}


es.onmessage = (ev) => {
if (isPaused) return;
try {
const data = JSON.parse(ev.data);
addReading(data);
log('Recibido: ' + JSON.stringify(data));
} catch (e) {
log('Error parseando dato: ' + e);
}
}


es.onerror = (err) => {
log('Error SSE — revisar servidor o CORS: ' + err);
// cierre automático en caso de fallo grave
// es.close(); es = null;
}
}


function disconnect() {
if (!es) return;
es.close();
es = null;
log('Conexión SSE cerrada');
btnConnect.disabled = false;
btnDisconnect.disabled = true;
}


btnConnect.addEventListener('click', connect);
btnDisconnect.addEventListener('click', disconnect);
btnToggle.addEventListener('click', () => {
isPaused = !isPaused;
btnToggle.textContent = isPaused ? 'Reanudar recepción' : 'Pausar recepción';
log(isPaused ? 'Recepción pausada' : 'Recepción reanudada');
});


// auto-connect on load (opcional)
// connect();