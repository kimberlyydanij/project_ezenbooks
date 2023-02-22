import '../../css/bootstrap.min.css';
import '../../css/style.css';
import '../../css/header.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import {
  faCartShopping,
  faMagnifyingGlass,
  faUser,
  faScrewdriverWrench,
  faBolt,
} from '@fortawesome/free-solid-svg-icons';
import Categories from '../../pages/Categories';
import { useActiveMenu } from 'react-active-menu';
const menu = 'category';

const Header = () => {
  const { registerTrigger } = useActiveMenu({
    smooth: true,
  });
  return (
    <div className='main-menu'>
      <div className='container-fluid'>
        <div className='row'>
          <div className='col-xl-2 col-lg-2 mt-4 mb-4'>
            <div className='header__logo'>
              <a href='/'>
                <img src='../img/MainLogo.png' alt='Main Logos' />
              </a>
            </div>
          </div>
          <div className='container colums-row col-xl-8 col-lg-8'>
            <div className='row'>
              <nav className='header__menu triggers'>
                <ul>
                  <li>
                    <a href='/'>
                      <button
                        className='btn-act'
                        ref={registerTrigger('home')}
                        type='button'
                      >
                        Home
                      </button>
                    </a>
                  </li>
                  <li>
                    <a href='/category'>
                      <button
                        className='btn-act'
                        ref={registerTrigger('category')}
                        type='button'
                      >
                        카테고리
                      </button>
                    </a>
                    <ul className='dropdown'>
                      <Categories name={menu} />
                    </ul>
                  </li>
                  <li>
                    <a href='/bestseller'>
                      <button
                        className='btn-act'
                        ref={registerTrigger('bestseller')}
                        type='button'
                      >
                        베스트셀러
                      </button>
                    </a>
                  </li>
                  <li className='pick20'>
                    <a href='/pick20'>
                      <button
                        className='btn-act'
                        ref={registerTrigger('pick20')}
                        type='button'
                      >
                        UserPick
                        <FontAwesomeIcon
                          icon={faBolt}
                          size='sm'
                          color='#301fbf'
                        />
                        20
                      </button>
                    </a>
                  </li>
                  <li>
                    <a href='/newest'>
                      <button
                        className='btn-act'
                        ref={registerTrigger('newest')}
                        type='button'
                      >
                        신간
                      </button>
                    </a>
                  </li>
                </ul>
              </nav>
            </div>
            <div className='row'>
              <div className='search__right col-xl-9 col-lg-7'>
                <div className='input-group'>
                  <div className='form-outline'>
                    <input
                      type='search'
                      id='main-search'
                      className='form-control'
                    />
                    <label className='form-label' htmlFor='main-search'></label>
                  </div>
                  <button type='button' className='btn btn-search'>
                    <FontAwesomeIcon icon={faMagnifyingGlass} />
                  </button>
                </div>
              </div>
            </div>
          </div>
          <div className='col-xl-2 col-lg-2 container colums-row'>
            <div className='header__right'>
              <div className='header__right__auth mt-2'>
                <a href='#'>Login</a>/ &nbsp;&nbsp;
                <a href='#'>SignUp</a>
              </div>

              <div className='row'>
                <div className='header__right__widget container d-flex justify-content-end mt-4'>
                  {/*  운영자 메뉴, 운영자만 접근 가능 */}
                  <div className='fontawsome' id='fascrewdriverwrench'>
                    <a href='/admin'>
                      <FontAwesomeIcon icon={faScrewdriverWrench} size='3x' />
                    </a>
                  </div>

                  <div className='fontawsome' id='fauser'>
                    <a href='/mypage'>
                      <FontAwesomeIcon icon={faUser} size='3x' />
                    </a>
                  </div>
                  <div className='fontawsome' id='facartshopping'>
                    <a href='/cart'>
                      <FontAwesomeIcon icon={faCartShopping} size='3x' />
                    </a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Header;