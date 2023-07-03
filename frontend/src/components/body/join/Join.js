import style from './Join.module.css';
import {Link} from 'react-router-dom';


export default function () {

  return (
    <div className={style.join_container}>
      <div>
        <span className={`${style.join_title} d-flex justify-content-center`}>회원가입</span>
        <hr></hr>
        <Link to="/joinbyemail">
          <p className={style.join_mail}>
            <i className={`${style.mail_icon} ri-mail-send-line`}></i>
            이메일 인증으로 가입
          </p>
        </Link>
        <Link to="/joinbyphone">
          <p className={style.join_phone}>
            <i className={`${style.phone_icon} ri-smartphone-line`}></i>
            핸드폰 인증으로 가입
          </p>
        </Link>
      </div>
    </div>
  )

}