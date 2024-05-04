import './App.css';
import Navbar from './components/Navbar';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Pagos from './pages/Pagos';
import Proveedores from './pages/Proveedores';
function App() {
  return (
    <>
    <Router>
      <Navbar/>
      <Routes>
        <Route path='/' exact Component={Home}/>
        <Route path='/pagos' Component={Pagos}/>
        <Route path='/proveedores' Component={Proveedores}/>
      </Routes>
    </Router>
    </>
    
  );
}

export default App;
