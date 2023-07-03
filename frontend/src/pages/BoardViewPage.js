import ViewForm from "../components/body/board/ViewForm";
import 'bootstrap/dist/css/bootstrap.min.css';
import Reply from "../components/body/board/Reply";
import {useLocation} from "react-router-dom";
import {useEffect, useState} from "react";
import axios from "axios";
import ListButton from "../components/listButton/ListButton";


export default function ({user}) {
  const location = useLocation();
  const [replys, setReplys] = useState([]);
  const [liked, setLiked] = useState({isLike: false, count: 0});
  const [bookMarked, setBookMarked] = useState({isSubscribed: false});
  const {from} = location.state;


  const getReply = async () => {
    try {
      await axios({
        method: "get",
        url: `/api/v1/comments/${from.id}`,
      }).then((resp) => {
        setReplys(resp.data)
      })
    } catch (err) {
      console.log(err)
    }
  }

  const getLike = async () => {
    await axios({
      method: "get",
      url: `/api/v1/likes/posts/${from.id}`,
    }).then((resp) => {
      setLiked({isLike: resp.data.isLike, count: resp.data.count})
    })
  }

  const getBookMark = () => {
    axios({
      method: "get",
      url: `/api/v1/bookmarks/${from.id}`,
    }).then((resp) => {
      console.log(resp.data.isSubscribed)
      setBookMarked(prev => ({isSubscribed: resp.data.isSubscribed}))
    })
  }

  useEffect(() => {
    getReply();
    getLike();
    getBookMark();
  }, [])


  return (
    <>
      <ViewForm post={from} user={user}></ViewForm>
      <Reply replys={replys} setReplys={setReplys} id={from.id} liked={liked} setLiked={setLiked}
             bookMarked={bookMarked} setBookMarked={setBookMarked} user={user}></Reply>
      <ListButton></ListButton>
      <div style={{marginTop: "120px"}}>
      </div>
    </>
  )
}