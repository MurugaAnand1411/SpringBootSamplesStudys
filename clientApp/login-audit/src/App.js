import React,{useState,useEffect} from "react";
import {
  BrowserRouter,
  Route,
  Routes
} from "react-router-dom";
import HomePage from "./components/Home/HomePage";
import Layout from "./components/Layout/Layout";
import Forgot from "./components/Login/Forgot";
import LoginPage from "./components/Login/LoginPage";
import SignupPage from "./components/Login/SignupPage";
import Receipt from "./components/Receipt/Receipt";
import SyncLoader from "react-spinners/SyncLoader"
import Invoice from "./components/Invoice/Invoice";

function App() {
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true)
    setTimeout(() => {
      setLoading(false)
    }, 3000)
  }, [])
  return (
    <div>
      {
      loading ?
      
      <div className="spinnerstyle">
      <SyncLoader
      color={"#201920"}
      size={150}
      loading={loading}
      /></div>

      :
    
    <div>
      <Layout>
      <BrowserRouter>
      <Routes>
        <Route  exact path="/" element={<LoginPage/>}/>
        <Route  path="/signup" element ={<SignupPage/>}/>
        <Route path='/forgot-password' element={<Forgot/>} />
        <Route path='/home' element={<HomePage/>} />
        <Route path='/receipt' element={<Receipt/>} />
        <Route path='/invoice' element={<Invoice/>}/>
      </Routes>
      </BrowserRouter>
      </Layout>
    </div>
}
</div>
  );
}

export default App;