import 'bootstrap/dist/css/bootstrap.min.css';
import style from './List.module.css';
import { useState, useEffect } from "react";
import axios from 'axios';

export default function List({ posts,setPosts }) {
  useEffect (()=>{
    axios({
      method: 'get',
      url: '/api/v1/posts'
    }).then(resp => {
      setPosts(resp.data);
    });
  },[])
  return (
    <>
      {posts.map((post,i) => {
        return (
          <div className={`${style.content} d-flex justify-content-center mt-3`}
            key={i}>
            <div className={`${style.content_box}`}>
              <div className={`${style.title} d-flex justify-content-start mt-3`}>
                <strong>{post.title}</strong>
              </div>
              <div className={`${style.sub_content} d-flex justify-content-start mt-3`}>
                <p>
                  {post.contents}
                </p>
              </div>
            </div>
          </div>
        )
      })}
    </>
  )
}