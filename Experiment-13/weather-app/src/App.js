import React, { useState } from "react";
import { getWeather } from "./services/WeatherService";
import WeatherChart from "./components/WeatherChart";

function App() {
  const [city, setCity] = useState("");
  const [data, setData] = useState(null);

  const fetchWeather = async () => {
    try {
      const result = await getWeather(city);
      setData(result);
    } catch {
      alert("Error fetching weather");
    }
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h3>24WH1A05C6_Pravalika</h3>
      <h2>React Weather App</h2>

      <input
        type="text"
        placeholder="Enter city"
        onChange={(e) => setCity(e.target.value)}
      />

      <button onClick={fetchWeather}>Get Weather</button>

      <div
        style={{
          width: "500px",
          height: "300px",
          margin: "auto"
        }}
      >
        <WeatherChart data={data} />
      </div>
    </div>
  );
}

export default App;