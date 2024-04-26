import React,{useState,useEffect} from 'react'
import { deleteEmployee, listEmployees,inTime,outTime,checkBit } from '../services/EmployeeService';
import {useNavigate } from 'react-router-dom';

const ListEmployeeComponent = () => {
    const [employees,setEmployees]=useState([]);
    const [clockInDisabled, setClockInDisabled] = useState(1);
    

    useEffect(()=>{
       getAllEmployees();
    },[])

    function getAllEmployees(){
        listEmployees().then((response)=>{
            //console.log(response.data);
        setEmployees(response.data);
    }).catch(error=>{
        console.error(error);
    })
    }

    function addNewEmployee(){
        console.log("sdcvs");
        window.location.href='/add-employee';
    }
    function updateEmployee(id)
    {
        window.location.href=`/edit-employee/${id}`;
    }
    function removeEmployee(id)
    {
        console.log(id);
        deleteEmployee(id).then((response)=>{
           getAllEmployees();
        }).catch(error=>{
            console.error(error);
        })
        
    }
    function checkInTime(id)
    {
        console.log("dvvf in");
        inTime(id).then((response)=>{
            

            checkBit(id).then((response)=>{
                console.log("id in");
                //setClockInDisabled(response.data);
               // document.getElementById("ci")[1].disabled=clockInDisabled;
            }).catch(error=>{
                console.error(error);
            })



               
            
            
            getAllEmployees();
        }).catch(error=>{
            console.error(error);
        })
        
    }
    function checkOutTime(id)
    {
        console.log("dvvf out");
        outTime(id).then((response)=>{
            

            checkBit(id).then((response)=>{
                console.log("id out");
                //setClockInDisabled(response.data);
                //document.getElementById("co")[1].disabled=clockInDisabled;
            }).catch(error=>{
                console.error(error);
            })




            getAllEmployees();
        }).catch(error=>{
            console.error(error);
        })
       
    }

    function checkDuration(id)
    { 
       
        window.location.href=`/duration/${id}`;

    }



    


  return (
    <div className='container'>
        <h2 className='text-center'> List of employees</h2>
        <button className='btn btn-primary mb-2' onClick={addNewEmployee} >Add employee</button>
        <table className='table table-striped table-bordered'>
            <thead>
                <tr>
                    {/* <td>Id</td> */}
                    <td>Firstname</td>
                    <td>secondname</td>
                    <td>email id</td>
                    {/* <td>biyt</td> */}
                    <td>Actions</td>
                </tr>
            </thead>
            <tbody>
                {
                    employees.map(employee=>
                        <tr key={employee.id}>
                            {/* <td>{employee.id}</td> */}
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                            {/* <td>{employee.bit}</td> */}
                            <td>
                                <button className='btn btn-info' onClick={()=>updateEmployee(employee.id) }>Update</button>

                                <button className='btn btn-danger' onClick={()=>removeEmployee(employee.id)} 
                                style={{marginLeft:'10px'}}>Delete</button>

                                <button className="btn btn-success" onClick={()=>checkInTime(employee.id)} disabled={!employee.bit} style={{marginLeft:'10px'}}>Clock-In</button>
                                <button className="btn btn-danger"  onClick={()=>checkOutTime(employee.id)} disabled={employee.bit} style={{marginLeft:'10px'}}>Clock-Out</button>
                                <button className="btn btn-info" onClick={()=>checkDuration(employee.id)} disabled={!employee.bit} style={{marginLeft:'10px'}}>TimeSheet</button>


                            </td>
                        </tr>
                    ) 
                }
                
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent;
