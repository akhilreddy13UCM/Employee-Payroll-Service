import React,{useEffect,useState} from 'react'

import { deleteAll, listEmployees } from '../services/EmployeeService'
import ListEmployeeComponent from './ListEmployeeComponent';

const HeaderComponent = () => {
  // const [employees,setEmployees]=useState([]);
  function del()
  {
    {
      const enteredPin = prompt('Enter your Manager PIN:');

    // Check if the entered PIN is correct
    if (enteredPin === '1234') {
      deleteAll().then((response)=>{
        console.log("wsfek");
        // setEmployees(response.data);
        window.location.href='/';
    }).catch(error=>{
        console.error(error);
    })
    } else {
        alert('Invalid PIN'); // Show alert if PIN is incorrect
    }
    }

  }
  return (
    <div>
        <nav className='navbar navbar-dark bg-dark'>
            <a className='navbar-brand' href=" ">Employee Payroll Services</a>
            <button className="btn btn-danger"  onClick={()=>del()} >Start New Payroll</button>
        </nav>
        
    </div>
  )
}

export default HeaderComponent