import style from './BookMark.module.css'


export default function () {
  return (
   <div className={style.container}>
    <div className={style.info_box}>
      <h3>북마크 <i class="ri-bookmark-3-fill" style={{color : "#FFD228"}}></i></h3>
    </div>
    <div className={style.bookmark_list}>
      글 목록 박스
    </div>

   </div>
  )
}