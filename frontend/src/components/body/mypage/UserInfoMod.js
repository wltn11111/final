import style from './UserInfoMod.module.css';


export default function () {
  return (
    <div className="container" style={{ margin: "30px", width: "960px" }}>
      <div style={{ borderBottom: "3px solid black", paddingBottom: "10px", marginBottom: "16px" }}>
        <h3 className={style.h}>회원정보 수정 </h3>
      </div>
      <div>
        <ul className={style.infomod_ul}>
          <li className={style.infomod_li}>
            <strong>로그인 정보</strong>
          </li>
          <li className={style.infomod_li}>
            <div>이름</div>
            <div>user.name</div>
          </li>
          <li className={style.infomod_li}>
            <div>이메일</div>
            <div><input type='text' placeholder='이메일 입력'></input></div>
          </li>
          <li className={style.infomod_li}>
            <div>아이디</div>
            <div><input type='text' placeholder='아이디 입력'></input></div>
          </li>
          <li className={style.infomod_li}>
            <div>비밀번호</div>
            <div><input type='text' placeholder='*******'></input></div>
          </li>
          <li className={style.infomod_li}>
            <div>비밀번호 확인</div>
            <div><input type='text' placeholder='*******'></input></div>
          </li>
        </ul>
      </div>
      <div className='d-flex justify-content-center'
        style={{ marginTop: "62px" }}>
        <button className='btn btn-dark' style={{ paddingLeft: "20px", paddingRight: "20px" }}>변경</button>
      </div>
    </div>
  )
}