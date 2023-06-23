import { Link } from 'react-router-dom';
import style from './Sidebar.module.css'

export default function () {

  return (
    <div style={{marginTop : "20px" , marginLeft : "20px"}}>
      <ul className={style.mypage_ul}>
        <li style={{marginBottom : "12px"}} className ={style.side_list}><strong style={{fontSize : "22px"}}
        >마이페이지</strong></li>
        <Link to = "/"><li className={style.side_list}>내 정보</li> </Link>
        <Link to = "/"><li className={style.side_list}>내 정보 수정</li> </Link>
        <Link to = "/"><li className={style.side_list}>커뮤니티</li> </Link>
        <Link to = "/"><li className={style.side_list}>회원 탈퇴</li> </Link>
      </ul>
    </div>
  )
}