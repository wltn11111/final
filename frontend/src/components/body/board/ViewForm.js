import 'bootstrap/dist/css/bootstrap.min.css';
import style from './ViewForm.module.css';
import axios from "axios";
import { useState, useEffect } from "react";


const Button = () => {
  return (
    <div className='d-flex justify-content-end mt-3' style={{ width: "800px", margin: "auto" }}>
      <button class="btn btn-dark">수정</button>
      <button class="ms-2 btn btn-dark">삭제</button>
    </div>
  )
}


export default function ViewForm({ posts }) {
  return (
    <>
      <div className={style.view_container}>
        <div className={`${style.view_title} mt-4`}>

        </div>
        <div className={`${style.view_content} mt-4`}>
          {posts.contents}
        </div>
        <Button></Button>
      </div>

    </>

  )
}




