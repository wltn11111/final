import { useState,  useEffect } from "react";
import Editor from "./Editor";
import axios from "axios";

function Category ({post,setPost}) {


useEffect(()=>{
  setPost(prev => ({...prev,category : "자유"}))
}, [])

  return (

      <select defaultValue={"자유"} onChange={(e) => {setPost(prev => ({...prev, category : e.target.value}))}}>
        <option key={"라이프"} value={"라이프"}>라이프</option>
        <option key={"스포츠"} value={"스포츠"}>스포츠</option>
        <option key={"연예"} value={"연예"}>연예</option>
        <option key={"자유"} value={"자유"}>자유</option>
      </select>
    )
}

function Title ({post,setPost}) {
  return (
    <div>
      <input type = "text" value = {post.title} onChange={(e) => {
        setPost(prev => ({...prev,title : e.target.value}))
      }}></input>
    </div>
  )
}

export default function WriteForm () {
const [post,setPost] = useState({
  title : "",
  content : "",
  category : ""
})



  return (
    <>
    <Category post={post} setPost={setPost}></Category>
    <Title post = {post} setPost = {setPost}></Title>
    <Editor post = {post} setPost = {setPost}></Editor>
    <div style={{marginTop : "100px"}}><button onClick={()=>{
      axios.post("/api/v1/posts", post)
      .then((res)=>{console.log(res)})
    }}>글 작성</button></div>

  </>

  )
}