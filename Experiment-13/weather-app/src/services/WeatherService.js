import axios from "axios";

const API_KEY = "a9fa61350dff204dabf22d57af2f7434";

export const getWeather = async (city) => {
  const res = await axios.get(
    `https://api.openweathermap.org/data/2.5/forecast?q=${city}&appid=${API_KEY}&units=metric`
  );
  return res.data;
};