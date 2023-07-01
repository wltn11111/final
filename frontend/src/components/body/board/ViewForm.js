import 'bootstrap/dist/css/bootstrap.min.css';
import style from './ViewForm.module.css';
import axios from "axios";
import { useState, useEffect } from "react";
import Editor from './Editor';
import { useNavigate, useParams } from 'react-router-dom';


const Button = ({post}) => {
  const Navigate = useNavigate();
  const delPost = () => {
    if (window.confirm('정말 삭제하시겠습니까?')){
      axios.delete(`/api/v1/posts/${post.id}`)
      Navigate('/posts')
    }
    return;
  }

  return (
    <div className='d-flex justify-content-end mt-3' style={{ width: "800px", margin: "auto"}}>
      <button className={`${style.btn} btn btn-dark`}
        onClick={() => {
          Navigate('/modpost/' + post.id , {state : post})
        }}
      >수정</button>
      <button className={`${style.btn} btn btn-dark ms-2`}
      onClick={delPost}
      >삭제</button>
    </div>
  )
}


const convertToKorean = (category) => {
  return [
    ["FREEDOM", "자유"],
    ["IT", "IT"],
    ["SPORTS", "운동"],
    ["FASHION", "패션"]
  ].filter(c => c[0] === category)
  .map(c => c[1]);
}


export default function ViewForm({post}) {

  return (
    <>
      <div className={style.view_container}>
      <div className={style.category_box}>
      <div className={`${style.view_category} d-flex justify-content-start`}>
        {convertToKorean(post.category)}
      </div>
      </div>
        <div className={`${style.view_title} mt-4`}>
          {post.title}
        </div>
        <div className={`${style.view_content} mt-4`}>
           <div dangerouslySetInnerHTML={{ __html:post.contents}}></div>
        </div>
        <Button post = {post}></Button>
      </div>
    </>

  )
}




