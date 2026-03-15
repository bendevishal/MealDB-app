export const fetchMeal = async () => {

  const response = await fetch(
    "http://localhost:8080/api/meals/least-ingredients"
  );

  return response.json();
};