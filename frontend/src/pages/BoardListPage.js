import List from "../components/body/board/List";
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import BoardBanner from "../components/body/banner/BoardBanner";
import BannerSearch from "../components/body/banner/BannerSearch";
import { useEffect , useState} from "react";
import PostButton from "../components/postButton/PostButton";
import axios from "axios";



export default function ({posts,setPosts}) {

  // useEffect (()=>{
  //   axios({
  //     method: 'get',
  //     url: '/api/v1/posts'
  //   }).then(resp => {
  //     setPosts(resp.data);
  //   });
  // },[])
  const getPost = async () => {
    try {
      await axios({
        method: 'get',
        url: '/api/v1/posts'
      }).then(resp => {
        setPosts(resp.data);
      });
    } catch (err) {
      alert(err);
    }
  }


  useEffect(()=>{
    getPost();
  },[])


  let[fade,setFade] = useState('')
  useEffect(()=>{
    setTimeout(()=>{
      setFade('end')
    },100)
    return(()=> {
      setFade('')
    })
},[])

  return (
   <div className={`start ${fade}`}>
      <Header></Header>
      <BoardBanner></BoardBanner>
      <BannerSearch></BannerSearch>
      <List posts={posts}></List>
      <Footer></Footer>
      <PostButton></PostButton>
    </div>
  )
}