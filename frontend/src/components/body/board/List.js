import 'bootstrap/dist/css/bootstrap.min.css';
import style from './List.module.css';
import { useState,  useEffect } from "react";
import axios from 'axios';

export default function List({posts}) {
return (
<>
{posts.map((e,i)=> {
  return (
<div className={`${style.content} d-flex justify-content-center mt-3`}>
<div className={`${style.content_box}`}>
<div className={`${style.title} d-flex justify-content-start mt-3`}>
<strong>{posts[i].title}</strong>
</div>
<div className={`${style.sub_content} d-flex justify-content-start mt-3`}>
 <p>
  {posts[i].contents}
 </p>
</div>
</div>
</div>
) })}
</>
    )

}