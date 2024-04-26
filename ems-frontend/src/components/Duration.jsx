// import React, { useEffect, useState } from 'react'
// import { duration } from '../services/EmployeeService';
// import {useParams} from 'react-router-dom';


// const Duration = () => {

//   const {id}=useParams();
//   const [time,displayTime]=useState([]);

//   useEffect(()=>{
//     duration(id).then((response)=>{
//       displayTime(response.data);
//       console.log(response.data);
//     }).catch(error=>{
//       console.error(error);
//     })
//   },[])

//   return (
//     <div>Duration</div>
//   )
// }

// export default Duration;

import React, { useEffect, useState } from 'react';
import { duration,checkBit } from '../services/EmployeeService';
import { useParams } from 'react-router-dom';

const Duration = () => {
  const { id } = useParams();
  const [time, displayTime] = useState([]);

  useEffect(() => {
    duration(id)
      .then((response) => {
        displayTime(response.data);
        console.log(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  }, []);

  const renderTimeRows = () => {
    return (time.slice(0, time.length - 1).map((_, index) => (
      index % 2 === 0 && (
        <tr key={index}>
          <td>{time[index]}</td>
          <td>{time[index + 1]}</td>
        </tr>
      )
    )))
  }

  const renderSalaryStatement = () => {
    const lastIndex = time.length - 1;
    return <p>Your salary is {time[lastIndex]}</p>;
  };

  return (
    <div className='container'>
      <h2 className='text-center'>Duration</h2>
      <table className='table table-striped table-bordered'>
        <thead>
          <tr>
            <th>LogIn Time</th>
            <th>LogOut Time</th>
          </tr>
        </thead>
        <tbody>{renderTimeRows()}</tbody>
      </table>
      {renderSalaryStatement()}
    </div>
  );
};

export default Duration;
