import 'bootstrap/dist/css/bootstrap.min.css';
import style from './List.module.css';
import { useState, useEffect } from "react";
import { Link, useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function List({ posts }) {

  //렌더링할 데이터들을 담을변수
  const [list,setList] = useState([]);
  const [isLoading, setIsLoaing] = useState(true);

  const fetchMoreData = () => {
    setIsLoaing(true);
    setList(list.concat(posts.slice(0,20)));
    setIsLoaing(false);
  }

  return (
    <div className={`${style.container}`}>
      {posts.map((post, i) => {
        return (
          <div>
          <Link to={`/post/${post.id}`} state={{ from: post }}>
            <div className={`${style.content} mt-4`}
              key={i}>
              <div className={`${style.content_box} mt-4`}>
                <div className={`${style.title} d-flex justify-content-start mt-3`}>
                  <strong>{post.title}</strong>
                </div>
                <div className={`${style.sub_content} d-flex justify-content-start mt-3`}>
                  <p dangerouslySetInnerHTML={{ __html: post.contents }}>
                  </p>
                </div>
              </div>
            </div>
          </Link>
          </div>
        )
      })}
    </div>
  )
}