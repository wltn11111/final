import 'bootstrap/dist/css/bootstrap.min.css';
import style from './List.module.css';
import { useState,  useEffect } from "react";
import axios from 'axios';

export default function List() {

const [contents,setContents] = useState([{}])

axios.get('/board').then((resp)=>{
  setContents(resp.data)
})

return (

<>
{contents.map((e,i)=> {
<div className={`${style.content} d-flex justify-content-center`}>
<div className={`${style.content_box}`}>
<div className={`${style.title} d-flex justify-content-start mt-3`}>
<strong>{contents.title}</strong>
</div>
<div className={`${style.sub_content} d-flex justify-content-start mt-3`}>
 <p>
  {contents.content}
 </p>
</div>
</div>
</div>
 })}
</>
    )

}