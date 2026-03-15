import React, { useEffect, useState } from "react";
import MealCard from "./MealCard";
import { fetchMeal } from "./api";

function App() {

  const [meal, setMeal] = useState(null);

  useEffect(() => {

    fetchMeal().then(data => setMeal(data));

  }, []);

  return (

    <div>

      <h1>MealDB App</h1>

      <MealCard meal={meal} />

    </div>

  );

export default App;
