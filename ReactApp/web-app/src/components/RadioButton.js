import React, { useState } from 'react';

const RadioButton = () => {
  const [selectedOption, setSelectedOption] = useState('');

  const handleOptionChange = (event) => {
    setSelectedOption(event.target.value);
    console.log(event.target.value," Clicked..");
  };

  return (
    <div>
      <h3>Choose an option:</h3>
      <label>
        <input
          type="radio"
          value="Option 1"
          checked={selectedOption === 'Option 1'}
          onChange={handleOptionChange}
        />
        Option 1
      </label>
      <label>
        <input
          type="radio"
          value="Option 2"
          checked={selectedOption === 'Option 2'}
          onChange={handleOptionChange}
        />
        Option 2
      </label>
      <label>
        <input
          type="radio"
          value="Option 3"
          checked={selectedOption === 'Option 3'}
          onChange={handleOptionChange}
        />
        Option 3
      </label>
    </div>
  );
};

export default RadioButton;
