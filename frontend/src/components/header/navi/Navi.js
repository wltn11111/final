import style from './Navi.module.css';
import { Link } from 'react-router-dom';


function Navi () {
return (
<nav class="navbar d-none d-md-block navbar-expand-lg mt-3">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class={style.navi +" " +"nav-item"} id='test'>
        <div className={style.circle} ></div>
        <Link to = "/" className='nav-link active' aria-current = 'page'>Magazine Story </Link>
        </li>
        <li class="nav-item">
          <Link to = "/posts" className='nav-link active'>Contents</Link>
        </li>
      </ul>
    </div>
  </div>
</nav>
)
}

export default Navi;