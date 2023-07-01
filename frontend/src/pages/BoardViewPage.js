import ViewForm from "../components/body/board/ViewForm";
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from "../components/header/Header";
import Footer from "../components/footer/Footer";
import Reply from "../components/body/board/Reply";
import { useLocation } from "react-router-dom";
import { useState } from "react";
import axios from "axios";
import { useEffect } from "react";
import ListButton from "../components/listButton/ListButton";


export default function () {
  const location = useLocation();
  const [replys, setReplys] = useState([]);
  const [liked,setLiked ] = useState({isLike : false , count : 0});
  const [likeCount , setLikeCount] = useState();
  const [post, setPost] = useState({});
  const { from } = location.state;

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
      method : "get",
      url : `/api/v1/likes/posts/${from.id}`,
    }).then((resp) => {
      console.log(resp.data.isLike)
      console.log(from.id)
      setLiked({isLike : resp.data.isLike , count : resp.data.count })
    })
  }

  useEffect(() => {
    getReply();
    getLike();
  },[])

  return (
    <>
      <ViewForm post={from}></ViewForm>
      <Reply replys={replys} setReplys={setReplys} id={from.id} liked = {liked} setLiked = {setLiked} likeCount = {likeCount} ></Reply>
      <ListButton></ListButton>
      <div style={{ marginTop: "80px" }}>
        <Footer></Footer>
      </div>
    </>
  )
}