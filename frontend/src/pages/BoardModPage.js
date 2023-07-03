import ModForm from '../components/body/board/ModForm';

export default function ({setPosts, posts}) {

  return (
    <>
      <ModForm setPosts={setPosts} posts={posts}></ModForm>
      <div style={{marginTop: "110px"}}></div>
    </>
  )

}