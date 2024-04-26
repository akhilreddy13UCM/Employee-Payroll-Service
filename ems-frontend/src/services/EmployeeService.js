import axios from "axios";

 const REST_API_BASE_URL="http://3.144.106.114:8080/api/employees";



 export const listEmployees=()=>axios.get(REST_API_BASE_URL);

 export const createEmployee=(employee)=>axios.post(REST_API_BASE_URL,employee);

export const getEmployee=(employeeId)=>axios.get(REST_API_BASE_URL+"/"+employeeId);

export const updateEmployee=(employeeId,employee)=>axios.put(REST_API_BASE_URL+"/"+employeeId,employee);

export const deleteEmployee=(employeeId)=>axios.delete(REST_API_BASE_URL+"/"+employeeId);

// export const inTime=(employeeId,employee)=>axios.put(REST_API_BASE_URL+"/inTime/"+employeeId,employee);
export const inTime=(employeeId)=>axios.put(REST_API_BASE_URL+"/inTime/"+employeeId);

export const outTime=(employeeId)=>axios.put(REST_API_BASE_URL+"/outTime/"+employeeId);

export const duration=(employeeId)=>axios.get(REST_API_BASE_URL+"/duration/"+employeeId);

export const checkBit=(employeeId)=>axios.get(REST_API_BASE_URL+"/bit/"+employeeId);

export const deleteAll=()=>axios.delete(REST_API_BASE_URL+"/deleteAll");