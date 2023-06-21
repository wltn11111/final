import style from './PostButton.module.css'
import { Link } from 'react-router-dom'
import img from '../../assets/button.png';



export default function () {
  return (
    <Link to = "/newpost">
    <div className={style.post}>
     <img src = {img} style={{width : "100%", height : "100%"}}></img>
    </div>
    </Link>

  )
}