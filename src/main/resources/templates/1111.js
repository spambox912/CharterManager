
	import React, { useState, useEffect } from 'react';
import axios from 'axios';

const DropdownList = () => {
  const [records, setRecords] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8081/api/records')
      .then(response => {
        setRecords(response.data);
      })
      .catch(error => {
        console.error(error);
      });
  }, []);

  return (
    <div>
      <select>
        {records.map(record => (
          <option key={record.id} value={record.id}>{record.name}</option>
        ))}
      </select>
    </div>
  );
};

<label>ziemniaki</label>

export default DropdownList;
