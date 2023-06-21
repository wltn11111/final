import 'bootstrap/dist/css/bootstrap.min.css';
import style from './ViewForm.module.css';
import axios from "axios";
import { useState,  useEffect } from "react";



const Button = ()=> {
  return (
    <div className='d-flex justify-content-end mt-3' style={{width:"800px", margin : "auto"}}>
      <button class="btn btn-dark">수정</button>
      <button class="ms-2 btn btn-dark">삭제</button>
    </div>
  )
}


export default function ViewForm () {
  let [content,setContent ] = useState ({
  id : 0 , title : "123123123", contents : "123123123", author : "",
  category : "",
  createdDate : "",
  modifiedDate : ""})

    // axios.get(`/user?ID=`).then((resp)=>{
    //    setContent(resp.data)
    //   })

  return (
  <div className="container">
  <div className={`${style.view_title} mt-2`}>
    123
  </div>
  <div className={`${style.view_content} mt-4`}>

  </div>
  <Button></Button>
  </div>

  )

}




