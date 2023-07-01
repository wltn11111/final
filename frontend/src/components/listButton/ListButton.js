import style from './ListButton.module.css'
import { useEffect } from 'react';
import Aos from 'aos'
import { Link } from 'react-router-dom'


export default function () {
  useEffect(() => {
    Aos.init();
  }, []);

  return (
    <Link to="/posts">
      <div className={style.list}
        data-aos="fade-in"
        data-aos-delay="100"
        data-aos-duration="1200">
        <i className={`${style.icon} ri-file-list-line`}></i>
      </div>
    </Link>
  )
}