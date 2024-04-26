
import './App.css'
import { useState } from 'react'
import ListEmployeeComponent from './components/ListEmployeeComponent'
import HeaderComponent from './components/HeaderComponent'
import FooterComponent from './components/FooterComponent'
import { BrowserRouter,Routes,Route } from 'react-router-dom'
import EmployeeComponent from './components/EmployeeComponent'
import Duration from './components/Duration'
function App() {
  const [count, setCount] = useState(0)

  return (
    <> 
      <BrowserRouter>

        <HeaderComponent/>
        <Routes>
            {/* // http://localhost/3000 */}
              <Route path='/' element={<ListEmployeeComponent/>}></Route>

            {/* // http://localhost/3000/add-employee */}
            <Route path='/add-employee' element={<EmployeeComponent/>}></Route>
            
            {/* // http://localhost/3000/edit-employee */}
            <Route path='/edit-employee/:id' element={<EmployeeComponent/>}></Route>

            
            {/* // http://localhost/3000/duration */}
            <Route path='/duration/:id' element={<Duration/>}></Route>  
        </Routes>
        <FooterComponent/>
        </BrowserRouter>
    </>
  )
}

export default App
