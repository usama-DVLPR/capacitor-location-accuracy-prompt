import { LocationAccuracyPlugin } from 'capacitor-location-accuracy-prompt';

window.testEcho = () => {
    const inputValue = document.getElementById("echoInput").value;
    LocationAccuracyPlugin.echo({ value: inputValue })
}
