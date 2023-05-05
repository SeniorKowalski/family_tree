import styles from './header.module.scss';

const Header = () => {
    return (
        <div className={styles.header}>
            <img src='/tree.svg' alt='tree' width={50} />
            <nav>
                <ul>
                    <li>
                        <a href='/'>Дерево</a>
                    </li>
                    <li>
                        <a href='/'>О проекте</a>
                    </li>
                </ul>
            </nav>
        </div>
    );
};

export default Header;
