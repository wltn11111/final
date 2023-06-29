import logo from './logo.svg';
import 'remixicon/fonts/remixicon.css';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';
import axios from 'axios';
import { useEffect, useMemo, useRef, useState } from 'react';
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
import CheckPw from './components/body/mypage/CheckPw';
import UserInfoMod from './components/body/mypage/UserInfoMod';
import UserOut from './components/body/mypage/UserOut';
import MyComunity from './components/body/mypage/MyComunity';
import BoardModPage from './pages/BoardModPage';
import ScrollToTop from './ScrollToTop';
import BookMark from './components/body/mypage/BookMark';

function App() {
  const [posts, setPosts] = useState([]);


  return (
    <div className="container-flud">
      <ScrollToTop />
      <Routes>
        <Route path="/" element={<Index></Index>} />
        <Route path="/posts" element={<BoardListPage posts = {posts} setPosts = {setPosts}></ BoardListPage>} />
        <Route path='/newpost' element={<BoardWritePage setPosts={setPosts}></BoardWritePage>} />
        <Route path='/post/:id' element={<BoardViewPage></BoardViewPage>} />
        <Route path='/modpost/:id' element={<BoardModPage
          setPosts={setPosts} posts={posts}></BoardModPage>}></Route>
        <Route path="/search" element={<Search></Search>}></Route>
        <Route path="/login" element={<LoginPage></LoginPage>}></Route>
        <Route path="/join" element={<JoinPage></JoinPage>}></Route>
        <Route path="/mypage" element={<MyPage></MyPage>}>
          <Route path="info" element={<UserInfo></UserInfo>}></Route>
          <Route path="reconfirm" element={<CheckPw></CheckPw>}></Route>
          <Route path="bookmark" element={<BookMark></BookMark>}></Route>
          <Route path="infomod" element={<UserInfoMod></UserInfoMod>}></Route>
          <Route path="userout" element={<UserOut></UserOut>}></Route>
          <Route path="mycommunity" element={<MyComunity></MyComunity>}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
