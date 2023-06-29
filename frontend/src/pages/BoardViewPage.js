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
  const [post, setPost] = useState({});
  const { from } = location.state;

  const getPost = () => {
    // post 작업 영역
  }


  const getReply = async () => {
    try {
      await axios({
        method: "get",
        url: `/api/v1/replies/${from.id}`,
      }).then((resp) => {
        setReplys(resp.data)
        console.log(resp.data)
      })
    } catch (err) {
      console.log(err)
    }
  }

  useEffect(() => {
    getReply();
  }, [])


  return (
    <>
      <Header></Header>
      <ViewForm post={from}></ViewForm>
      <Reply replys={replys} setReplys={setReplys} id={from.id}></Reply>
      <ListButton></ListButton>
      <div style={{ marginTop: "80px" }}>
      <Footer></Footer>
      </div>
    </>
  )
}