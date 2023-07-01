import ModForm from '../components/body/board/ModForm';
import Header from "../components/header/Header"
import Footer from "../components/footer/Footer"

export default function ({setPosts,posts}) {

  return (
    <>
      <ModForm setPosts = {setPosts} posts={posts}></ModForm>
      <div style={{marginTop : "60px"}}> <Footer></Footer> </div>
    </>
  )

}