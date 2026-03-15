import React from "react";

function MealCard({ meal }) {

  if (!meal) return <div>Loading...</div>;

  return (
    <div style={{textAlign:"center"}}>

      <h2>{meal.strMeal}</h2>

      <img
        src={meal.strMealThumb}
        alt={meal.strMeal}
        width="300"
      />

      <p>{meal.strCategory}</p>

    </div>
  );
}

export default MealCard;