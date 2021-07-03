const Fake = ({ cars }) => {
  return (
    <div>
      <h1>In All</h1>
      <div>
        {cars.map((x) => (
          <h1>{x.id}</h1>
        ))}
      </div>
    </div>
  );
};

export default Fake;
