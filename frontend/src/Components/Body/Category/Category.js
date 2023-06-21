import 'bootstrap/dist/css/bootstrap.css';
import style from './Category.module.css'
import { useEffect } from 'react';
import Aos from 'aos';
import "aos/dist/aos.css";

export default function () {
  useEffect(()=>{
    Aos.init();
  }, []);

  return (

    <div className={`${style.container} container d-flex justify-content-center`}>
      <div data-aos="fade-up"
      data-aos-delay="100"
      data-aos-duration="1000"
      data-aos-easing="ease-in-out"
      className={style.category}>
      123 </div>
      <div data-aos="fade-up"
     data-aos-delay="200"
     data-aos-duration="1000"
     data-aos-easing="ease-in-out"
     className={style.category}>
     123 </div>
     <div data-aos="fade-up"
     data-aos-delay="400"
     data-aos-duration="1000"
     data-aos-easing="ease-in-out"
     className={style.category}>
     123 </div>
     <div data-aos="fade-up"
     data-aos-delay="600"
     data-aos-duration="1000"
     data-aos-easing="ease-in-out"
     className={style.category}>
     123 </div>
    </div>


  )



}