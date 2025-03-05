import React, { useState, useEffect } from 'react';

const CheckBox = () => {
  const [checkedItems, setCheckedItems] = useState({
    item1: false,
    item2: false,
    item3: false,
  });

  const handleCheckboxChange = (event) => {
    setCheckedItems({
      ...checkedItems,
      [event.target.name]: event.target.checked,
    });
  };

  useEffect(() => {
    console.log('Checked items:', checkedItems);
  }, [checkedItems]);

  return (
    <div>
      <h3>Select items:</h3>
      <label>
        <input
          type="checkbox"
          name="item1"
          checked={checkedItems.item1}
          onChange={handleCheckboxChange}
        />
        Item 1
      </label>
      <label>
        <input
          type="checkbox"
          name="item2"
          checked={checkedItems.item2}
          onChange={handleCheckboxChange}
        />
        Item 2
      </label>
      <label>
        <input
          type="checkbox"
          name="item3"
          checked={checkedItems.item3}
          onChange={handleCheckboxChange}
        />
        Item 3
      </label>
    </div>
  );
};

export default CheckBox;
