import React from 'react';
 
const ListKey = () => {
  const names = ['n1', 'n2', 'n3'];
  const employees = [
    { id: 1, name: 'Employee 1' },
    { id: 2, name: 'Employee 2' },
    { id: 3, name: 'Employee 3' }
  ];
 
  return (
    <div>
      <h1>Names List</h1>
      <ul>
        {names.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
 
      <h1>Employees List</h1>
      <ul>
        {employees.map((employee) => (
          <li key={employee.id}>{employee.name}</li>
        ))}
      </ul>
    </div>
  );
};
 
export default ListKey;
 