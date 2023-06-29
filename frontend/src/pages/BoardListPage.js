import List from "../components/body/board/List";
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import BoardBanner from "../components/body/banner/BoardBanner";
import BannerSearch from "../components/body/banner/BannerSearch";
import { useEffect , useState} from "react";
import PostButton from "../components/postButton/PostButton";
import axios from "axios";



export default function ({posts,setPosts}) {

  const [page, setPage] = useState();


  const getPost = async () => {
    try {
      await axios({
        method: 'get',
        url: '/api/v1/posts'
      }).then(resp => {
        setPosts(resp.data);
        setPage(1);
      });
    } catch (err) {
      alert(err);
    }
  }

  useEffect(()=>{
    getPost();
  },[])


const [fade,setFade] = useState('')
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
      <List posts={posts} page = {page} setPage={setPage}></List>
      <Footer></Footer>
      <PostButton></PostButton>
    </div>
  )
}