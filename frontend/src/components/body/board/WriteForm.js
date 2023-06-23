import { useState,  useEffect } from "react";
import Editor from "./Editor";
import axios from "axios";
import style from "./WriteForm.module.css"
import 'bootstrap/dist/css/bootstrap.css';

function Button ({post}) {
  return (
    <div className="d-flex justify-content-end"
     style={{width : "800px" , height : "40px", margin : "auto" , marginTop : "48px"}}>
    <button className="btn btn-light"
    onClick={()=>{
    axios.post("/api/v1/posts", post)
    .then((res)=>{console.log(res)})
  }}>글 작성</button></div>
  )
}



function Category ({post,setPost}) {
useEffect(()=>{
  setPost(prev => ({...prev,category : "자유"}))
}, [])
  return (
    <div style={{width : "800px", margin : "auto" , marginTop : "10px" , marginBottom : "10px"}}>
      <select
      style={{width : "140px", height : "36px"}}
      class="form-select" aria-label="Default select example"
      defaultValue={"자유"} onChange={(e) => {setPost(prev => ({...prev, category : e.target.value}))}}>
        <option key={"라이프"} value={"라이프"}>라이프</option>
        <option key={"스포츠"} value={"스포츠"}>스포츠</option>
        <option key={"연예"} value={"연예"}>연예</option>
        <option key={"자유"} value={"자유"}>자유</option>
      </select>
      </div>
    )
}

function Title ({post,setPost}) {
  return (
   <div style={{marginBottom : "20px"}}>
      <p className={style.title_p}>
      <input type = "text"
      placeholder="글 제목"
      className={style.title_input}
      value = {post.title}
      onChange={(e) => {
      setPost(prev => ({...prev,title : e.target.value}))
      }}></input></p>
    </div>

  )
}


export default function WriteForm () {
  const[post,setPost] = useState ({title : "", content : "" , author : ""})
  return (
    <div className="container mt-4">
    <Category post={post} setPost={setPost}></Category>
    <Title post = {post} setPost = {setPost}></Title>
    <Editor post = {post} setPost = {setPost}></Editor>
    <Button post={post}></Button>
  </div>
  )
}