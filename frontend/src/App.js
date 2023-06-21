import logo from './logo.svg';
import 'remixicon/fonts/remixicon.css';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import axios from 'axios';
import { useState } from 'react';
import { Route, Router, Routes } from 'react-router-dom';
import BoardWritePage from './Pages/BoardWritePage';
import BoardViewPage from './Pages/BoardViewPage';
import BoardListPage from './Pages/BoardListPage';
import Index from './Pages/Index';
import Search from './Pages/Search';
import LoginPage from './Pages/LoginPage';
import JoinPage from './Pages/JoinPage';
import MyPage from './Pages/MyPage';


function App() {
  const [posts,setPosts] = useState([{id : 0, title : "1",
  contents : "test", author : "3ddddddd", category : "4", createdDate : "5", modifiedDate : "6" },])

  const [user,setUser] = useState({id : "" , password : ""})

//   axios.get('/posts').then((resp)=>{
//    setPosts(resp.data)
//  })


  return (
    <div className="container-flud">
    <Routes>
    <Route path = "/" element = {<Index></Index>}/>
    <Route path = "/posts" element = {<BoardListPage posts = {posts}></ BoardListPage>}/>
    <Route path='/newpost' element = {<BoardWritePage></BoardWritePage>}/>
    <Route path='/post' element = {<BoardViewPage></BoardViewPage>}/>
    <Route path = "/search" element = {<Search></Search>}></Route>
    <Route path = "/login" element = {<LoginPage></LoginPage>}></Route>
    <Route path = "/join" element = {<JoinPage></JoinPage>}></Route>
    <Route path = "/mypage" element = {<MyPage></MyPage>}>

    </Route>

    </Routes>
    </div>

  );
}

export default App;
