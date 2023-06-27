import 'bootstrap/dist/css/bootstrap.min.css';
import { Link } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import style from './Search.module.css';

export default function () {
  const Navigate = useNavigate();
  return (
    <>
    <div className={`${style.search_area} d-md-none`}>
    <div className={`${style.search_top}`}>
    <input type='text' className={style.search_input} placeholder='Search'></input>
    <i class={`${style.search_icon} ri-search-line`}></i>
    <i class={`${style.search_close} ri-close-fill`}
    onClick={()=>{
      Navigate(-1)
    }} ></i>
    </div>
    <div className={style.search_text}>
     <span className='mt-4'>관심사를 검색해보세요</span>
     <ul className={style.search_word_list}>
      <li>검색어 </li>
      <li>검색어</li>
      <li>검색어</li>
     </ul>
    </div>
    </div>

    <div className={`${style.search_md_area} d-none d-md-block`}>
      <div className={style.search_md_top}>
        <div className={style.input_box}>
         <span style={{borderBottom : "solid 2px black"}}><input type='text' placeholder='Whats your interests?'></input> </span>
          <i class={`${style.search_md_icon} ri-search-line`}></i>
          <i class={`${style.search_md_close} ri-close-fill`}
          onClick={()=>{
            Navigate(-1)
          }}></i>


        </div>
      </div>

  </div>
    </>

  )
}
