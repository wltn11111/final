import 'bootstrap/dist/css/bootstrap.min.css';
import style from './ViewForm.module.css';
import axios from "axios";
import { useState, useEffect } from "react";
import Editor from './Editor';
import { useNavigate, useParams } from 'react-router-dom';


const Button = ({id}) => {
  const Navigate = useNavigate();

  const delPost = () => {
    console.log(id);
    if (window.confirm('정말 삭제하시겠습니까?')){
      axios.delete(`/api/v1/posts/${id}`)
      Navigate('/posts')
    }
    return;
  }

  return (
    <div className='d-flex justify-content-end mt-3' style={{ width: "800px", margin: "auto"}}>
      <button className={`${style.btn} btn btn-dark`}
        onClick={() => {
          Navigate('/modpost/' + id)
        }}
      >수정</button>
      <button className={`${style.btn} btn btn-dark ms-2`}
      onClick={delPost}
      >삭제</button>
    </div>
  )
}


export default function ViewForm({post}) {
  let { id } = parseInt(useParams());

  return (
    <>
      <div className={style.view_container}>
        <div className={`${style.view_title} mt-4`}>
          {post.title}
        </div>
        <div className={`${style.view_content} mt-4`}>
           <div dangerouslySetInnerHTML={{ __html:post.contents}}></div>
        </div>
        <Button id = {post.id}></Button>
      </div>
    </>

  )
}




