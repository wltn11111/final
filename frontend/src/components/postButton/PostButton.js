import style from './PostButton.module.css'
import 'bootstrap/dist/css/bootstrap.css';
import { Link } from 'react-router-dom'
import img from '../../assets/./images/button.png';


const Button = () => {
  return (
  <Link to="/newpost">
  <div className={style.post}>
    <img src={img} style={{ width: "100%", height: "100%" }}/>
  </div>
</Link>
  )
}

export default function ({user}) {
  return (
    <div className='d-none d-md-block'>
    <Button></Button>
    </div>
  )
}


