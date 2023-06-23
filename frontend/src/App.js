import logo from './logo.svg';
import 'remixicon/fonts/remixicon.css';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import axios from 'axios';
import { useState } from 'react';
import { Route, Routes } from 'react-router-dom';
import BoardWritePage from './pages/BoardWritePage';
import BoardViewPage from './pages/BoardViewPage';
import BoardListPage from './pages/BoardListPage';
import Index from './pages/Index';
import Search from './pages/Search';
import LoginPage from './pages/LoginPage';
import JoinPage from './pages/JoinPage';
import MyPage from './pages/MyPage';
import UserInfo from './components/body/mypage/UserInfo';


function App() {
  const [posts, setPosts] = useState([{
    id: 0, title: "1",
    contents: "test", author: "3ddddddd", category: "4", createdDate: "5", modifiedDate: "6"
  },])

  const [user, setUser] = useState({ id: "", password: "" })

  //   axios.get('/posts').then((resp)=>{
  //    setPosts(resp.data)
  //  })

  return (
    <div className="container-flud">
      <Routes>
        <Route path="/" element={<Index></Index>} />
        <Route path="/posts" element={<BoardListPage posts={posts}></ BoardListPage>} />
        <Route path='/newpost' element={<BoardWritePage></BoardWritePage>} />
        <Route path='/post' element={<BoardViewPage></BoardViewPage>} />
        <Route path="/search" element={<Search></Search>}></Route>
        <Route path="/login" element={<LoginPage></LoginPage>}></Route>
        <Route path="/join" element={<JoinPage></JoinPage>}></Route>

        <Route path="/mypage" element={<MyPage></MyPage>}>
         <Route path="info" element={<UserInfo></UserInfo>}></Route>

        </Route>

      </Routes>
    </div>

  );
}

export default App;
