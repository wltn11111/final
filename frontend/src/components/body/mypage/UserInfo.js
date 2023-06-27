import 'bootstrap/dist/css/bootstrap.css';
import style from './UserInfo.module.css';
import profile from '../../../assets/images/mypage_profile.png'


export default function () {
  return (
    <div className="infobox" style={{ marginTop: "30px", width: " 70%", height: "500px" }}>
      <div className={style.profile}>
        <img src = {profile} style={{width : "93%" , height : "100%" , marginTop : "16px"}}></img>
      </div>
      <div className={style.info}>
        <ul className={style.info_ul}>
          <li className={style.info_li}><strong>회원정보</strong></li>
          <li className={style.info_li}>
            <div className={style.l}>이름</div>
            <div className={style.r}>user.name</div></li>
          <li className={style.info_li}>
            <div className={style.l}>아이디</div>
            <div className={style.r}>user.id</div></li>
          <li className={style.info_li}>
            <div className={style.l}>이메일</div>
            <div className={style.r}>user.email</div>
          </li>
          <li className={style.info_li}>
          <div className={style.l}>가입 날짜</div>
            <div className={style.r}>user.register_date</div>
            </li>
        </ul>
      </div>

    </div>

  )



}
