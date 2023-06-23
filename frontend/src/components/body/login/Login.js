import { useState } from 'react';
import style from './Login.module.css';
import 'bootstrap/dist/css/bootstrap.css';


export default function () {

  const [loginUser, setLoginUser] = useState({ id: "", password: "" })
  return (
    <div className={style.login_container}>
      <span className={`${style.login_title} d-flex justify-content-center`}>로그인</span>
      <hr style={{ color: "black" }}></hr>
      <div className={style.login_box}>
        <div className={style.idbox}>
          <p style={{ marginBottom: "8px", fontSize: "14px" }}>아이디</p>
          <input type='text' placeholder='아이디를 입력해주세요'
            className={style.login_input}></input>
        </div>
        <div className={style.pwbox}>
          <p style={{ marginBottom: "8px", fontSize: "14px" }}>비밀번호</p>
          <input type='text' placeholder='비밀번호를 입력해주세요'
            className={style.login_input}></input>
        </div>
        <div className={style.btn_box}>
          <button className='btn btn-dark'>로그인</button>
        </div>
      </div>
    </div>

  )
}